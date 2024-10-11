package uz.personal.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.personal.practice.api_integration.hemis.HemisIntegrationApi;
import uz.personal.practice.api_integration.hemis.StudentHemis;
import uz.personal.practice.api_integration.hemis.StudentHemisInfoResponse;
import uz.personal.practice.domain.*;
import uz.personal.practice.repository.*;

import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentSchoolDataRepository studentSchoolDataRepository;
    private final DtmStudentResultRepository stmStudentResultRepository;
    private final HemisIntegrationApi hemisIntegrationApi;
    private final HemisStudentRepository hemisStudentRepository;
    private final UniversityRepository universityRepository;
    private final StudentRecommendationRepository studentRecommendationRepository;
    private final HemisNotFoundRepository hemisNotFoundRepository;
    private final ProfRepository profRepository;
    private final OrphanStudentRepository orphanStudentRepository;

    public void checkStudentFoundInOrphan() {
        int count = 1;
        List<OrphanStudent> students = orphanStudentRepository.findAllByIsActiveIsNull();
        for (OrphanStudent student : students) {
            System.out.println(student.getPinfl());
            StudentHemisInfoResponse studentInfo = hemisIntegrationApi.studentInfoByPinflTemporary(student.getPinfl());
            if (studentInfo.getObject() != null) {
                StudentHemis object = studentInfo.getObject();
//                student.setUniversityCode(object.getUniversityCode());
//                student.setUniversityName(object.getUniversityName());
//                student.setSpecialityCode(object.getSpecialityCode());
//                student.setSpeciality(object.getSpecialityName());
//                student.setPaymentForm(object.getPaymentFormName());
//                student.setEduForm(object.getEduFormName());
//                student.setCourse(object.getCourse());
//                student.setStudentStatus(object.getStatusName());
//                if (object.getStatusCode().equals("12")) {
//                    student.setExpelReason(object.getExpelReason());
//                    student.setStatusOrderDate(object.getStatusOrderDate());
//                }
//                student.setGraduatedDate(object.getGraduatedDate());
                student.setEduType(object.getEduTypeName());
//                student.setIsActive(TRUE);
            }
//            else student.setIsActive(FALSE);
            orphanStudentRepository.save(student);
            System.out.println(count);
            count++;
        }
        System.out.println("the end");
    }

    public void addDtmResultToStudentSchoolData() {
        List<StudentSchoolData> students = studentSchoolDataRepository.findAllByIsActiveIsNull();
        for (StudentSchoolData student : students) {
            Optional<DtmStudentResult> optional = stmStudentResultRepository.findByPinfl(student.getPinfl());
            if (optional.isPresent()) {
                student.setResult(optional.get().getResult());
                student.setIsActive(TRUE);
            } else student.setIsActive(FALSE);
        }
        studentSchoolDataRepository.saveAll(students);
        System.out.println("the end");
    }

    public void addStudentHemisInfoToStudentSchoolData() {
        List<StudentSchoolData> students = studentSchoolDataRepository.findAllByIsActiveIsNotNull();
        for (StudentSchoolData student : students) {
            System.out.println(student.getPinfl());
            StudentHemisInfoResponse studentInfo = hemisIntegrationApi.getStudentInfo(student.getPinfl(), 2023);
            if (studentInfo.getObject() != null) {
                StudentHemis object = studentInfo.getObject();
                student.setUniversityCode(object.getUniversityCode());
                student.setUniversity(object.getUniversityName());
                student.setEduForm(object.getEduFormName());
                student.setSpecialityCode(object.getSpecialityCode());
                student.setSpeciality(object.getSpecialityName());
                student.setPaymentForm(object.getPaymentFormName());
                student.setStatus(object.getStatusName());
            }
            student.setIsActive(TRUE);
            studentSchoolDataRepository.save(student);
        }
        System.out.println("the end");
    }

    public void checkStudentExistsInDTM() {
        int count = 1;
        List<HemisStudent> studentsInHEMIS = hemisStudentRepository.findAllByTypeIsNull();
        for (HemisStudent student : studentsInHEMIS) {
            Optional<StudentRecommendation> recommendation = studentRecommendationRepository.findStudentRecommendationByPinfl(student.getPinfl());
            recommendation.ifPresent(r -> student.setType(r.getType()));
            student.setChecked(TRUE);
            System.out.println(count);
            count++;
        }
        hemisStudentRepository.saveAll(studentsInHEMIS);
        System.out.println("the end");
    }

    //hemisdan joriy talabalarni yozib olish
    public void saveStudentHemis() {
        String tableNameStudent = "student_hemis";
        hemisStudentRepository.createStudentPartitionIInfoTable(tableNameStudent);
        for (String s : universityRepository.findAllUniversityCodes()) {
            hemisStudentRepository.insertStudentDataEveryMonth(tableNameStudent, s);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("success: " + s);
        }
        System.out.println("The end");
    }

    public void checkStudentFoundInHemis() {
        int count = 1;
        List<HemisNotFound> students = hemisNotFoundRepository.findAllByTypeIsNull();
        for (HemisNotFound student : students) {
            StudentHemisInfoResponse studentInfo = hemisIntegrationApi.studentInfoByPinflTemporary(student.getPinfl());
            if (studentInfo.getObject() != null) {
                StudentHemis object = studentInfo.getObject();
                student.setUniversityCodeInHemis(object.getUniversityCode());
                student.setUniversityInHemis(object.getUniversityName());
                student.setStatusInHemis(object.getStatusName());
                student.setPaymentFormCode(object.getPaymentFormCode());
                student.setCheckedOliy(TRUE);
            } else student.setCheckedOliy(FALSE);
            hemisNotFoundRepository.save(student);
            System.out.println(count);
            count++;
        }
        System.out.println("the end");
    }

    public void checkStudentFoundInProf() {
        int count = 1;
        List<HemisNotFound> students = hemisNotFoundRepository.findAllByTypeIsNull();
        for (HemisNotFound student : students) {
            Optional<Prof> profOptional = profRepository.findByPinfl(student.getPinfl());
            if (profOptional.isPresent()) {
                Prof prof = profOptional.get();
                student.setUniversityInProf(prof.getUniversity());
                student.setStatusInProf(prof.getStatus());
                student.setEduTypeInProf(prof.getEduType());
                student.setCheckedProf(TRUE);
            } else student.setCheckedProf(FALSE);
            hemisNotFoundRepository.save(student);
            System.out.println(count);
            count++;
        }
        System.out.println("the end");
    }
}
