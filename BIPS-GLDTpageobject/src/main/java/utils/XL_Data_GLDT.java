package utils;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.SkipException;

import pages.Jira_ticketPage;








public class XL_Data_GLDT {
	public static String xlfilepath =System.getProperty("user.dir")+ "\\src\\test\\resources\\Testdata\\GLDT_TestCases.xlsx";

	public static String caseID_R;// Read case id from XL Sheet
	public static String testData;//Read Test Data from XL Sheet
	static int sheet_Number = 1;///Update as per Module 
	public static String CaseID;
	public static String Product;
    public static String Countries;
    public static String Datetype;
    public static String Timeline;
    public static String userId;
	public static String password;
	public static String Fail_Value;
	public static int first_Row;
	public static int last_Row;
	
	

	

	public static void write_ActuaResult(int caseId_Row,String caseID_W) {
		File xlsxFile = new File(xlfilepath);
		try {
			// Creating input stream
			FileInputStream inputStream = new FileInputStream(xlsxFile);
			// Creating workbook from input stream
			Workbook workbook = WorkbookFactory.create(inputStream);
			// Reading first sheet of excel file
			Sheet sheet = workbook.getSheetAt(sheet_Number);
			// below row only case id cell data (Run actual column - ex- GLDT-3720) is
			// inserting//
			//sheet.getRow(caseId_row).getCell(caseId_cell).setCellValue(InitiateGlobalLaunchDates_Page.GLDT_Case_Id );
			sheet.getRow(caseId_Row).getCell(10).setCellValue(caseID_W);
			// Close input stream
			inputStream.close();
			// Crating output stream and writing the updated workbook
			FileOutputStream os = new FileOutputStream(xlsxFile);
			workbook.write(os);
			// Close the workbook and output stream
			workbook.close();
			os.close();
			System.out.println("Excel file has been updated successfully.");
		} catch (EncryptedDocumentException | IOException e) {
			System.err.println("Exception while updating an existing excel file.");
			e.printStackTrace();
		}
	}

	
	

	
	public static void pre_Requisite_Data_Write(int caseId_Row,String caseID_W) {
		// TODO Auto-generated method stub
		File xlsxFile = new File(xlfilepath);
		try {
			// Creating input stream
			FileInputStream inputStream = new FileInputStream(xlsxFile);
			// Creating workbook from input stream
			Workbook workbook = WorkbookFactory.create(inputStream);
			// Reading first sheet of excel file
			Sheet sheet = workbook.getSheetAt(sheet_Number);
			// below row only case id cell data (Run actual column - ex- GLDT-3720) is
			// inserting//
			//sheet.getRow(caseId_row).getCell(caseId_cell).setCellValue(InitiateGlobalLaunchDates_Page.GLDT_Case_Id );
			sheet.getRow(caseId_Row).getCell(6).setCellValue(caseID_W);
			// Close input stream
			inputStream.close();
			// Crating output stream and writing the updated workbook
			FileOutputStream os = new FileOutputStream(xlsxFile);
			workbook.write(os);
			// Close the workbook and output stream
			workbook.close();
			os.close();
			System.out.println("Excel file has been updated successfully.");
		} catch (EncryptedDocumentException | IOException e) {
			System.err.println("Exception while updating an existing excel file.");
			e.printStackTrace();
		}
		
	}

	public static void pre_Requisite_Data_Read(int TestData_Row) throws IOException {
		FileInputStream fStream = new FileInputStream(new File(xlfilepath));
		// Create workbook instance referencing the file created above
		XSSFWorkbook workbook = new XSSFWorkbook(fStream);
		// Get your first or desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(sheet_Number); // getting second sheet
		XSSFRow row3 = sheet.getRow(TestData_Row);
		XSSFCell cell3 = row3.getCell(6);
		testData =  cell3.toString();
		fStream.close();
		workbook.close();
	}
	
	
	public static XSSFCell GLDT_getCaseID(int CaseID_Row) throws Exception {

		FileInputStream fStream = new FileInputStream(new File(xlfilepath));

		// Create workbook instance referencing the file created above
		XSSFWorkbook workbook = new XSSFWorkbook(fStream);

		// Get your first or desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(1); // getting second sheet

        XSSFRow row3 = sheet.getRow(CaseID_Row);
		XSSFCell cell3 = row3.getCell(6);
		
		CaseID =  cell3.toString();
		fStream.close();
		workbook.close();
		return cell3;

	}
	
	public static void AnalysisAndInsight_getData(int Product_Row,int Countries_Row,int Datetype_Row,int Timeline_Row) throws Exception {

		FileInputStream fStream = new FileInputStream(new File(xlfilepath));

		// Create workbook instance referencing the file created above
		XSSFWorkbook workbook = new XSSFWorkbook(fStream);

		// Get your first or desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(1); // getting second sheet

		XSSFRow row1 = sheet.getRow(Product_Row);
		XSSFCell cell1 = row1.getCell(8);

		XSSFRow row2 = sheet.getRow(Countries_Row);
		XSSFCell cell2 = row2.getCell(8);
		
		XSSFRow row3 = sheet.getRow(Datetype_Row);
		XSSFCell cell3 = row3.getCell(8);

		XSSFRow row4 = sheet.getRow(Timeline_Row);
		XSSFCell cell4 = row4.getCell(8);

		//XSSFRow row3 = sheet.getRow(CaseID_Row);
		//XSSFCell cell3 = row3.getCell(8);
		Product = cell1.toString();
		Countries = cell2.toString();
		Datetype = cell3.toString();
		Timeline = cell4.toString();
		//CaseID =  cell3.toString();
		fStream.close();
		workbook.close();

	}
	
	public static XSSFCell RALD_getData(int CaseID_Row) throws Exception {

		FileInputStream fStream = new FileInputStream(new File(xlfilepath));

		// Create workbook instance referencing the file created above
		XSSFWorkbook workbook = new XSSFWorkbook(fStream);

		// Get your first or desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(1); // getting second sheet

        XSSFRow row3 = sheet.getRow(CaseID_Row);
		XSSFCell cell3 = row3.getCell(6);
		
		CaseID =  cell3.toString();
		fStream.close();
		workbook.close();
		return cell3;

	}
	



	public static void put_GLDT_caseID(int caseId_row) {

		File xlsxFile = new File(xlfilepath);
		try {
			// Creating input stream
			FileInputStream inputStream = new FileInputStream(xlsxFile);

			// Creating workbook from input stream
			Workbook workbook = WorkbookFactory.create(inputStream);

			// Reading first sheet of excel file
			Sheet sheet = workbook.getSheetAt(1);
			// below row only case id cell data (Run actual column - ex- GLDT-3720) is
			// inserting//
			//sheet.getRow(caseId_row).getCell(caseId_cell).setCellValue(InitiateGlobalLaunchDates_Page.GLDT_Case_Id );
			//sheet.getRow(caseId_row).getCell(8).setCellValue(InitiateGlobalLaunchDates_Page.GLDT_Case_Id );

			// Close input stream
			inputStream.close();

			// Crating output stream and writing the updated workbook
			FileOutputStream os = new FileOutputStream(xlsxFile);
			workbook.write(os);

			// Close the workbook and output stream
			workbook.close();
			os.close();

			System.out.println("Excel file has been updated successfully.");



		} catch (EncryptedDocumentException | IOException e) {
			System.err.println("Exception while updating an existing excel file.");
			e.printStackTrace();
		}

	}

	public static void write_RALD_caseID1(int caseId_Row,String RALD_Case_Id) {

		File xlsxFile = new File(xlfilepath);
		try {
			// Creating input stream
			FileInputStream inputStream = new FileInputStream(xlsxFile);

			// Creating workbook from input stream
			Workbook workbook = WorkbookFactory.create(inputStream);

			// Reading first sheet of excel file
			Sheet sheet = workbook.getSheetAt(1);
			// below row only case id cell data (Run actual column - ex- GLDT-3720) is
			// inserting//
			//sheet.getRow(caseId_row).getCell(caseId_cell).setCellValue(InitiateGlobalLaunchDates_Page.GLDT_Case_Id );
			//sheet.getRow(caseId_Row).getCell(10).setCellValue(InitiateGlobalLaunchDates_Page.RALD_Case_Id );

			// Close input stream
			inputStream.close();

			// Crating output stream and writing the updated workbook
			FileOutputStream os = new FileOutputStream(xlsxFile);
			workbook.write(os);

			// Close the workbook and output stream
			workbook.close();
			os.close();

			System.out.println("Excel file has been updated successfully.");



		} catch (EncryptedDocumentException | IOException e) {
			System.err.println("Exception while updating an existing excel file.");
			e.printStackTrace();
		}

	}
	
	public static void write_RALD_caseID2(int caseId_Row,String RALD_Case_Id) {

		File xlsxFile = new File(xlfilepath);
		try {
			// Creating input stream
			FileInputStream inputStream = new FileInputStream(xlsxFile);

			// Creating workbook from input stream
			Workbook workbook = WorkbookFactory.create(inputStream);

			// Reading first sheet of excel file
			Sheet sheet = workbook.getSheetAt(1);
			// below row only case id cell data (Run actual column - ex- GLDT-3720) is
			// inserting//
			//sheet.getRow(caseId_row).getCell(caseId_cell).setCellValue(InitiateGlobalLaunchDates_Page.GLDT_Case_Id );
			//sheet.getRow(caseId_Row).getCell(6).setCellValue(InitiateGlobalLaunchDates_Page.RALD_Case_Id );

			// Close input stream
			inputStream.close();

			// Crating output stream and writing the updated workbook
			FileOutputStream os = new FileOutputStream(xlsxFile);
			workbook.write(os);

			// Close the workbook and output stream
			workbook.close();
			os.close();

			System.out.println("Excel file has been updated successfully.");



		} catch (EncryptedDocumentException | IOException e) {
			System.err.println("Exception while updating an existing excel file.");
			e.printStackTrace();
		}

	}
	
	public static XSSFCell GLDT_getData(int CaseID_Row) throws Exception {

		FileInputStream fStream = new FileInputStream(new File(xlfilepath));

		// Create workbook instance referencing the file created above
		XSSFWorkbook workbook = new XSSFWorkbook(fStream);

		// Get your first or desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(1); // getting second sheet

        XSSFRow row3 = sheet.getRow(CaseID_Row);
		XSSFCell cell3 = row3.getCell(8);
		
		CaseID =  cell3.toString();
		fStream.close();
		workbook.close();
		return cell3;

	}
	public static void delete_Cell_Content_Data(int SRN,int ERN) throws Exception {

		File xlsxFile = new File(xlfilepath);
		try {
			// Creating input stream
			FileInputStream inputStream = new FileInputStream(xlsxFile);

			// Creating workbook from input stream
			Workbook workbook = WorkbookFactory.create(inputStream);

			// Reading first sheet of excel file
			Sheet sheet = workbook.getSheetAt(sheet_Number);


			int i =  SRN;
			int j = ERN;
			for(;i<=j;i++) {
				sheet.getRow(i).getCell(10).setCellValue("");

				sheet.getRow(i).getCell(11).setCellValue("");

				sheet.getRow(i).getCell(12).setCellValue("");

			}

			// Close input stream
			inputStream.close();

			// Crating output stream and writing the updated workbook
			FileOutputStream os = new FileOutputStream(xlsxFile);
			workbook.write(os);

			// Close the workbook and output stream
			workbook.close();
			os.close();

			System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");



		} catch (EncryptedDocumentException | IOException e) {
			System.err.println("Exception while updating an existing excel file.");
			e.printStackTrace();
		}

	}
public static void get_user_credential(int Row_Number) throws Exception {
		
		FileInputStream fStream = new FileInputStream(new String(xlfilepath));
		// Enter the path to your excel here

		// Create workbook instance referencing the file created above
		XSSFWorkbook workbook = new XSSFWorkbook(fStream);

		// Get your first or desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0); // getting first sheet Based on index([0,1,...]
		// XSSFSheet sheet = workbook.getSheet("Master_Test_Data"); //Based on sheet
		// name

		XSSFRow row1 = sheet.getRow(Row_Number);
		XSSFCell cell1 = row1.getCell(2);

		//XSSFRow row2 = sheet.getRow(Row_Number);
		XSSFCell cell2 = row1.getCell(3);

		 userId = cell1.toString();
		 password = cell2.toString();

		fStream.close();
		workbook.close();
		 
	}


	public static void write_CaseID(int caseId_Row,String caseID_W) {

		File xlsxFile = new File(xlfilepath);
		try {
			// Creating input stream
			FileInputStream inputStream = new FileInputStream(xlsxFile);

			// Creating workbook from input stream
			Workbook workbook = WorkbookFactory.create(inputStream);

			// Reading first sheet of excel file
			Sheet sheet = workbook.getSheetAt(sheet_Number);
			// below row only case id cell data (Run actual column - ex- GLDT-3720) is
			// inserting//
			//sheet.getRow(caseId_row).getCell(caseId_cell).setCellValue(InitiateGlobalLaunchDates_Page.GLDT_Case_Id );
			sheet.getRow(caseId_Row).getCell(10).setCellValue(caseID_W);

			// Close input stream
			inputStream.close();

			// Crating output stream and writing the updated workbook
			FileOutputStream os = new FileOutputStream(xlsxFile);
			workbook.write(os);

			// Close the workbook and output stream
			workbook.close();
			os.close();

			System.out.println("Excel file has been updated successfully.");



		} catch (EncryptedDocumentException | IOException e) {
			System.err.println("Exception while updating an existing excel file.");
			e.printStackTrace();
		}

	}
	
	public static void write_CaseIDAsPrerequiste(int caseId_Row,String caseID_W) {

		File xlsxFile = new File(xlfilepath);
		try {
			// Creating input stream
			FileInputStream inputStream = new FileInputStream(xlsxFile);

			// Creating workbook from input stream
			Workbook workbook = WorkbookFactory.create(inputStream);

			// Reading first sheet of excel file
			Sheet sheet = workbook.getSheetAt(sheet_Number);
			// below row only case id cell data (Run actual column - ex- GLDT-3720) is
			// inserting//
			//sheet.getRow(caseId_row).getCell(caseId_cell).setCellValue(InitiateGlobalLaunchDates_Page.GLDT_Case_Id );
			sheet.getRow(caseId_Row).getCell(6).setCellValue(caseID_W);

			// Close input stream
			inputStream.close();

			// Crating output stream and writing the updated workbook
			FileOutputStream os = new FileOutputStream(xlsxFile);
			workbook.write(os);

			// Close the workbook and output stream
			workbook.close();
			os.close();

			System.out.println("Excel file has been updated successfully.");



		} catch (EncryptedDocumentException | IOException e) {
			System.err.println("Exception while updating an existing excel file.");
			e.printStackTrace();
		}

	}

	public static void read_Test_Data(int TestData_Row) throws IOException {
		FileInputStream fStream = new FileInputStream(new File(xlfilepath));

		// Create workbook instance referencing the file created above
		XSSFWorkbook workbook = new XSSFWorkbook(fStream);

		// Get your first or desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(sheet_Number); // getting second sheet

		XSSFRow row3 = sheet.getRow(TestData_Row);
		XSSFCell cell3 = row3.getCell(8);

		testData =  cell3.toString();
		fStream.close();
		workbook.close();

	}
	
	public static void read_URL_Data(int TestData_Row) throws IOException {
		FileInputStream fStream = new FileInputStream(new File(xlfilepath));

		// Create workbook instance referencing the file created above
		XSSFWorkbook workbook = new XSSFWorkbook(fStream);

		// Get your first or desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0); // 

		XSSFRow row3 = sheet.getRow(TestData_Row);
		XSSFCell cell3 = row3.getCell(6);

		testData =  cell3.toString();
		fStream.close();
		workbook.close();

	}
	
	
	public static void read_CaseID(int TestData_Row) throws IOException {
		FileInputStream fStream = new FileInputStream(new File(xlfilepath));

		// Create workbook instance referencing the file created above
		XSSFWorkbook workbook = new XSSFWorkbook(fStream);

		// Get your first or desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(sheet_Number); // getting second sheet

		XSSFRow row3 = sheet.getRow(TestData_Row);
		XSSFCell cell4 = row3.getCell(6);

		testData =  cell4.toString();
		fStream.close();
		workbook.close();

	}

	
	
	public static void write_Pass_Result(int Row_Number) {
		////Actual_
		File xlsxFile = new File(xlfilepath);
		try {
			// Creating input stream
			FileInputStream inputStream = new FileInputStream(xlsxFile);

			// Creating workbook from input stream
			Workbook workbook = WorkbookFactory.create(inputStream);

			// Reading first sheet of excel file
			Sheet sheet = workbook.getSheetAt(sheet_Number);
			// below row only case id cell data (Run actual column - ex- GLDT-3720) is
			// inserting//
			//sheet.getRow(caseId_row).getCell(caseId_cell).setCellValue(InitiateGlobalLaunchDates_Page.GLDT_Case_Id );
			sheet.getRow(Row_Number).getCell(10).setCellValue("As expected");
			sheet.getRow(Row_Number).getCell(11).setCellValue("Pass");

			// Close input stream
			inputStream.close();

			// Crating output stream and writing the updated workbook
			FileOutputStream os = new FileOutputStream(xlsxFile);
			workbook.write(os);

			// Close the workbook and output stream
			workbook.close();
			os.close();

			System.out.println("Excel file has been updated successfully.");



		} catch (EncryptedDocumentException | IOException e) {
			System.err.println("Exception while updating an existing excel file.");
			e.printStackTrace();
		}

	}


	public static void write_Fail_Result_DependentTestCase(int SRN,int ERN,String MethodName) {
		////Actual_
		File xlsxFile = new File(xlfilepath);
		try {
			// Creating input stream
			FileInputStream inputStream = new FileInputStream(xlsxFile);

			// Creating workbook from input stream
			Workbook workbook = WorkbookFactory.create(inputStream);

			// Reading first sheet of excel file
			Sheet sheet = workbook.getSheetAt(sheet_Number);
			// below row only case id cell data (Run actual column - ex- GLDT-3720) is
			// inserting//
			//sheet.getRow(caseId_row).getCell(caseId_cell).setCellValue(InitiateGlobalLaunchDates_Page.GLDT_Case_Id );
			//sheet.getRow(SRN).getCell(11).setCellValue("Fail");
			Fail_Value="fail";
			
		    
			sheet.getRow(SRN).getCell(11).setCellValue(Fail_Value);

			sheet.getRow(SRN).getCell(10).setCellValue(MethodName);

			sheet.getRow(SRN).getCell(12).setCellValue(Jira_ticketPage.Jira_Id);
			int i=SRN+1;
			int j = ERN;
			for(;i<=j;i++) {
				sheet.getRow(i).getCell(11).setCellValue("Blocked");

				sheet.getRow(i).getCell(10).setCellValue("Skipped");	

			}

			// Close input stream
			inputStream.close();

			// Crating output stream and writing the updated workbook
			FileOutputStream os = new FileOutputStream(xlsxFile);
			workbook.write(os);

			// Close the workbook and output stream
			workbook.close();
			os.close();

			System.out.println("Excel file has been updated successfully.");
		//	if(GLDT_TestCases.testCaseName!="GLDT_TC_05" && GLDT_TestCases.testCaseName!= "GLDT_PrerequisteTC")
			XL_Data_GLDT.Fail_Value="";
            throw new SkipException("Skipping the execution");


		} catch (EncryptedDocumentException | IOException e) {
			System.err.println("Exception while updating an existing excel file.");
			e.printStackTrace();
		}

	}
	
	public static void write_Fail_Result(int SRN,int ERN,String MethodName) {
		////Actual_
		File xlsxFile = new File(xlfilepath);
		try {
			// Creating input stream
			FileInputStream inputStream = new FileInputStream(xlsxFile);

			// Creating workbook from input stream
			Workbook workbook = WorkbookFactory.create(inputStream);

			// Reading first sheet of excel file
			Sheet sheet = workbook.getSheetAt(sheet_Number);
			// below row only case id cell data (Run actual column - ex- GLDT-3720) is
			// inserting//
			//sheet.getRow(caseId_row).getCell(caseId_cell).setCellValue(InitiateGlobalLaunchDates_Page.GLDT_Case_Id );
			//sheet.getRow(SRN).getCell(11).setCellValue("Fail");
			Fail_Value="fail";
			
		    
			sheet.getRow(SRN).getCell(11).setCellValue(Fail_Value);

			sheet.getRow(SRN).getCell(10).setCellValue(MethodName);

			sheet.getRow(SRN).getCell(12).setCellValue(Jira_ticketPage.Jira_Id);
			int i=SRN+1;
			int j = ERN;
			for(;i<=j;i++) {
				sheet.getRow(i).getCell(11).setCellValue("Blocked");

				sheet.getRow(i).getCell(10).setCellValue("Skipped");	

			}

			// Close input stream
			inputStream.close();

			// Crating output stream and writing the updated workbook
			FileOutputStream os = new FileOutputStream(xlsxFile);
			workbook.write(os);

			// Close the workbook and output stream
			workbook.close();
			os.close();

			System.out.println("Excel file has been updated successfully.");
			
            throw new SkipException("Skipping the execution");


		} catch (EncryptedDocumentException | IOException e) {
			System.err.println("Exception while updating an existing excel file.");
			e.printStackTrace();
		}

	}
	
	










	//
	//	public static void read_CaseID(int CaseID_Row) throws Exception {
	//
	//		FileInputStream fStream = new FileInputStream(new File(BIPS_Login.xlfilepath));
	//
	//		// Create workbook instance referencing the file created above
	//		XSSFWorkbook workbook = new XSSFWorkbook(fStream);
	//
	//		// Get your first or desired sheet from the workbook
	//		XSSFSheet sheet = workbook.getSheetAt(sheet_Number); // getting second sheet
	//
	//		//		XSSFRow row = sheet.getRow(Product_Row);
	//		//		XSSFCell cell1 = row.getCell(8);
	//		//
	//		//		XSSFRow row1 = sheet.getRow(Reasn_Row);
	//		//		XSSFCell cell2 = row1.getCell(8);
	//
	//		XSSFRow row3 = sheet.getRow(CaseID_Row);
	//		XSSFCell cell3 = row3.getCell(8);
	//		//		Product = cell1.toString();
	//		//		Reason = cell2.toString();
	//		caseID_R =  cell3.toString();
	//		fStream.close();
	//		workbook.close();
	//
	//	}

	public static void Delete_Cell_Contents() throws Exception {
		File xlsxFile = new File(xlfilepath);
		try {
			// Creating input stream
			FileInputStream inputStream = new FileInputStream(xlsxFile);

			// Creating workbook from input stream
			Workbook workbook = WorkbookFactory.create(inputStream);

			// Reading first sheet of excel file
			Sheet sheet = workbook.getSheetAt(sheet_Number);// Based on index ..0,1,2...
			// Sheet sheet = workbook.getSheet("GLDT_Test_Cases"); //Based on sheet name

			// Clear_cell <= 12;

			for (int Clear_row = 1, Clear_cell = 10; Clear_cell <= 12; Clear_row++) {
				sheet.getRow(Clear_row).getCell(Clear_cell).setCellValue("");
				if (Clear_row == 294) {
					Clear_row = 0;
					Clear_cell++;
				}
			}

			// Close input stream
			inputStream.close();

			// Crating output stream and writing the updated workbook
			FileOutputStream os = new FileOutputStream(xlsxFile);
			workbook.write(os);

			// Close the workbook and output stream
			workbook.close();
			os.close();

			System.out.println("Excel file has been updated successfully.");

		} catch (EncryptedDocumentException | IOException e) {
			System.err.println("Exception while updating an existing excel file.");
			e.printStackTrace();
		}

		/////////

	}
	public static void read_TestCases_SRN_ERN(String methodName) throws IOException {
		FileInputStream fStream = new FileInputStream(new File(xlfilepath));
		// Create workbook instance referencing the file created above
		XSSFWorkbook workbook = new XSSFWorkbook(fStream);
		// Get your first or desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(sheet_Number); // getting second sheet
		int i;
		int j;
		int a = 0;

		for(i=1;i<1000;i++) {
			
			if(a==1) {
				break;
			}

			XSSFRow row = sheet.getRow(i);////Row number will vary.
			XSSFCell cell3 = row.getCell(1);//Test Case column
			String cellData =  cell3.toString();

			//System.out.println("Method Name:"+methodName+"Row number=:"+i+"Cell Data:"+cellData);

			if(methodName.equalsIgnoreCase(cellData)) {
				first_Row=i;
				//System.out.println("Starting row number="+i);
				j=++i;
				for(;j<1000;j++) {
					
					XSSFRow rowa = sheet.getRow(j);////Row number will vary.
					XSSFCell cell3a = rowa.getCell(1);//Test Case column
					String cellDataa =  cell3a.toString();
				
					if((cellDataa.startsWith("GLDT"))) {
					//if((cellDataa.equals("GLDT_TC_102"))) {
						
						last_Row=j-1;
						a=1;
						workbook.close();
						break;
						

					}

				}

			}
	


		
		}



		fStream.close();
		//workbook.close();
	}





	public static void write_Fail_Result_HP(int SRN,int ERN) {
		////Actual_
		File xlsxFile = new File(xlfilepath);
		try {
			// Creating input stream
			FileInputStream inputStream = new FileInputStream(xlsxFile);
			// Creating workbook from input stream
			Workbook workbook = WorkbookFactory.create(inputStream);
			// Reading first sheet of excel file
			Sheet sheet = workbook.getSheetAt(sheet_Number);
						int i=SRN;
			int j = ERN;
			for(;i<=j;i++) {
				sheet.getRow(i).getCell(11).setCellValue("Blocked");
				sheet.getRow(i).getCell(10).setCellValue("Skipped");	
			}
			// Close input stream
			inputStream.close();
			// Crating output stream and writing the updated workbook
			FileOutputStream os = new FileOutputStream(xlsxFile);
			workbook.write(os);
			// Close the workbook and output stream
			workbook.close();
			os.close();
			System.out.println("Excel file has been updated successfully.");
            throw new SkipException("Skipping the execution");
		} catch (EncryptedDocumentException | IOException e) {
			System.err.println("Exception while updating an existing excel file.");
			e.printStackTrace();
		}
	}
	
	
	public static void write_Fail_Result_IndependentCase(int SRN,int ERN,String MethodName) {
		////Actual_
		File xlsxFile = new File(xlfilepath);
		try {
			// Creating input stream
			FileInputStream inputStream = new FileInputStream(xlsxFile);

			// Creating workbook from input stream
			Workbook workbook = WorkbookFactory.create(inputStream);

			// Reading first sheet of excel file
			Sheet sheet = workbook.getSheetAt(sheet_Number);
			// below row only case id cell data (Run actual column - ex- GLDT-3720) is
			// inserting//
			//sheet.getRow(caseId_row).getCell(caseId_cell).setCellValue(InitiateGlobalLaunchDates_Page.GLDT_Case_Id );
			sheet.getRow(SRN).getCell(11).setCellValue("Fail");

			sheet.getRow(SRN).getCell(10).setCellValue(MethodName);

			sheet.getRow(SRN).getCell(12).setCellValue(Jira_ticketPage.Jira_Id);
			int i=SRN+1;
			int j = ERN;
			for(;i<=j;i++) {
				sheet.getRow(i).getCell(11).setCellValue("Blocked");

				sheet.getRow(i).getCell(10).setCellValue("Skipped");	

			}

			// Close input stream
			inputStream.close();

			// Crating output stream and writing the updated workbook
			FileOutputStream os = new FileOutputStream(xlsxFile);
			workbook.write(os);

			// Close the workbook and output stream
			workbook.close();
			os.close();

			System.out.println("Excel file has been updated successfully.");
			throw new SkipException("Skipping the execution");




		} catch (EncryptedDocumentException | IOException e) {
			System.err.println("Exception while updating an existing excel file.");
			e.printStackTrace();
		}

	}


	
}