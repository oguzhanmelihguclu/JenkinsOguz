package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateTestDataExcel {
	public static void main(String[] args) {
		Workbook workbook = new XSSFWorkbook();

		// Sheet1: Customer Kullanıcı Bilgileri
		Sheet sheet1 = workbook.createSheet("Sheet1");
		Object[][] userData = {
				{"Kullanıcı Adı", "Şifre",},
				{"customer.oguzhan@gmail.com", "Bsc.0425"},
		};
		populateSheet(sheet1, userData);

		// Sheet2: Admin Kullanıcı Bilgileri
		Sheet sheet2 = workbook.createSheet("Sheet2");
		Object[][] adminData = {
				{"Kullanıcı Adı", "Şifre",},
				{"admin.oguzhan@buysellcycle.com", "Bsc.0425"},
		};
		populateSheet(sheet2, adminData);

		// Sheet3: Gecersiz Kullanıcı Bilgileri
		Sheet sheet3 = workbook.createSheet("Sheet3");
		Object[][] gecersizData = {
				{"Kullanıcı Adı", "Şifre",},
				{"gecersiz@gmail.com", "Bsc.0425"},
		};
		populateSheet(sheet3, gecersizData);













		// Sheet4: Kullanıcı Bilgileri
		Sheet sheet4 = workbook.createSheet("Sheet4");
		Object[][] userDatas = {
				{"User Name", "Password"},
				{"customer.zeynep@gmail.com", "Bsc.0425"}
		};
		populateSheet(sheet4, userDatas);

		// Sheet5: Gecerli Kupon Bilgileri
		Sheet sheet5 = workbook.createSheet("Sheet5");
		Object[][] validCouponCode = {
				{"validCouponCode"},
				{"NEWUSER20"}
		};
		populateSheet(sheet5, validCouponCode);

		// Sheet6: Gecersiz Kupon Bilgileri
		Sheet sheet6 = workbook.createSheet("Sheet6");
		Object[][] invalidCouponCode = {
				{"invalidCouponCode"},
				{"NEWUSER30"}
		};
		populateSheet(sheet6, invalidCouponCode);

		// Sheet7: Gecerli Kart Bilgileri
		Sheet sheet7 = workbook.createSheet("Sheet7");
		Object[][] validCardData = {
				{"cardNumber", "expireDate", "CVV"},
				{"3714 496353 98431", "12 2026", "742"}
		};
		populateSheet(sheet7, validCardData);

		// Sheet8: Gecersiz Kart Bilgileri
		Sheet sheet8 = workbook.createSheet("Sheet8");
		Object[][] invalidCardData = {
				{"cardNumber", "expireDate", "CVV"},
				{"1111 111111 11111", "12 2019", "1"}
		};
		populateSheet(sheet8, invalidCardData);












































































































































































		// Excel dosyasını kaydet
		try (FileOutputStream fos = new FileOutputStream("src/test/resources/TestData.xlsx")) {
			workbook.write(fos);
			System.out.println("Excel dosyası başarıyla oluşturuldu: TestData.xlsx");
		} catch (IOException e) {
			System.err.println("Excel dosyası oluşturulurken hata meydana geldi: " + e.getMessage());
		}
	}

	private static void populateSheet(Sheet sheet, Object[][] data) {
		int rowCount = 0;
		for (Object[] rowData : data) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			for (Object field : rowData) {
				Cell cell = row.createCell(columnCount++);
				if (field instanceof String) {
					cell.setCellValue((String) field);
				} else if (field instanceof Integer) {
					cell.setCellValue((Integer) field);
				}
			}
		}
	}
}
