package uz.personal.practice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import uz.personal.practice.model.ResponseDto;
import uz.personal.practice.service.ExcelHelper;

@RestController()
@RequestMapping("api/excel/")
@RequiredArgsConstructor
public class ExcelHelperController {

    private final ExcelHelper excelHelper;

    @PostMapping(value = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadExcel(@RequestParam("file") MultipartFile file) {
        ResponseDto response = excelHelper.convertFromExcelToDatabase(file);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PostMapping(value = "upload/dtm", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadDtmExcel(@RequestParam("file") MultipartFile file) {
        ResponseDto response = excelHelper.convertFromExcelToDatabase2(file);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
