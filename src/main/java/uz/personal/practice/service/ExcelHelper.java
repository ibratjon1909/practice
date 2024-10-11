package uz.personal.practice.service;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.personal.practice.domain.DtmStudentResult;
import uz.personal.practice.domain.StudentSchoolData;
import uz.personal.practice.model.ResponseDto;
import uz.personal.practice.repository.DtmStudentResultRepository;
import uz.personal.practice.repository.StudentSchoolDataRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcelHelper {

    private final StudentSchoolDataRepository studentSchoolDataRepository;

    public ResponseDto convertFromExcelToDatabase(MultipartFile file) {
        try {
            IOUtils.setByteArrayMaxOverride(1000000000);

            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            Iterator<Sheet> sheetIterator = workbook.sheetIterator();

            int rowNumber = 0;
            while (sheetIterator.hasNext()) {
                Sheet sheet = sheetIterator.next();
                for (Row currentRow : sheet) {
                    if (rowNumber == 0) {
                        rowNumber++;
                        continue;
                    }
                    Iterator<Cell> cellsInRow = currentRow.iterator();
                    StudentSchoolData student = new StudentSchoolData();
                    int cellIdx = 0;
                    while (cellsInRow.hasNext()) {
                        Cell currentCell = cellsInRow.next();
                        switch (cellIdx) {
                            case 0:
                                student.setRegion(currentCell.getStringCellValue());
                                break;
                            case 1:
                                student.setDistrict(currentCell.getStringCellValue());
                                break;
                            case 2:
                                student.setSchool(currentCell.getStringCellValue());
                                break;
                            case 3:
                                if (currentCell.getCellType() == CellType.NUMERIC) {
                                    student.setSchoolTin(String.valueOf(currentCell.getNumericCellValue()));
                                } else
                                    student.setSchoolTin(currentCell.getStringCellValue());
                                break;
                            case 4:
                                student.setStudentClass(currentCell.getStringCellValue());
                                break;
                            case 5:
                                student.setFullName(currentCell.getStringCellValue());
                                break;
                            case 6:
                                student.setBirthDate(currentCell.getStringCellValue());
                                break;
                            case 7:
                                student.setSerialAndNumber(currentCell.getStringCellValue());
                                break;
                            case 8:
                                if (currentCell.getCellType() == CellType.NUMERIC) {
                                    student.setPinfl(String.valueOf(currentCell.getNumericCellValue()));
                                } else
                                    student.setPinfl(currentCell.getStringCellValue());
                                break;
                            default:
                                break;
                        }
                        cellIdx++;
                    }
                    if (student.getPinfl() != null) {
                        studentSchoolDataRepository.save(student);
                    }
                }
            }
            workbook.close();
            System.out.println("the end");
            return new ResponseDto(HttpStatus.OK.value(), "OK", LocalDateTime.now());
        } catch (Exception e) {
            return new ResponseDto(HttpStatus.BAD_REQUEST.value(), "Failed", LocalDateTime.now());
        }
    }

    private final DtmStudentResultRepository studentResultRepository;

    public ResponseDto convertFromExcelToDatabase2(MultipartFile file) {
        try {
            IOUtils.setByteArrayMaxOverride(1000000000);
            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);
            List<DtmStudentResult> list = new ArrayList<>();
            for (Row currentRow : sheet) {
                DtmStudentResult student = new DtmStudentResult();
                student.setPinfl(currentRow.getCell(0).getStringCellValue());
                student.setResult(currentRow.getCell(1).getNumericCellValue());
                list.add(student);
            }
            studentResultRepository.saveAll(list);
            workbook.close();
            System.out.println("the end");
            return new ResponseDto(HttpStatus.OK.value(), "OK", LocalDateTime.now());
        } catch (Exception e) {
            return new ResponseDto(HttpStatus.BAD_REQUEST.value(), "Failed", LocalDateTime.now());
        }
    }


}
