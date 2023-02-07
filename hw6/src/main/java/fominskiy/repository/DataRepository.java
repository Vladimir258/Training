package fominskiy.repository;

import fominskiy.persist.ExcData;
import org.apache.poi.hssf.usermodel.*;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class DataRepository {
    ArrayList<ExcData> arrayList = new ArrayList<>();
    ArrayList<ExcData> dataList = new ArrayList<>();

    public DataRepository(int sizeArr) {
        arrayList.ensureCapacity(sizeArr);
        dataList.ensureCapacity(sizeArr);
    }

    public int sizeArray() {
        return dataList.size();
    }
    public void rdFromExcel() throws IOException {
        arrayList.clear();
        dataList.clear();

        HSSFWorkbook myExcelBook = new HSSFWorkbook(Files.newInputStream(Paths.get("C:\\!Vova\\Project\\Java\\data.xls")));
        HSSFSheet mySheet = myExcelBook.getSheet("1");

        for (int i = 0; i <= mySheet.getLastRowNum(); i++) {

            Short shrt = null;

            try {
                shrt = mySheet.getRow(i).getLastCellNum();
            } catch (NullPointerException e) {
                System.out.println("Ошибка null");
            }

            ArrayList<String> temp = new ArrayList<>();

            if (shrt != null) {
                for (int j = 0; j < mySheet.getRow(i).getLastCellNum(); j++) {
                    Double d = null;
                    String s = null;

                    if (mySheet.getRow(i).getCell(j) == null) {
                        temp.add("нет данных");
                    } else {
                        if (mySheet.getRow(i).getCell(j).getCellType() == HSSFCell.CELL_TYPE_STRING) {
                            s = mySheet.getRow(i).getCell(j).getStringCellValue();
                        }

                        if (mySheet.getRow(i).getCell(j).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                            d = mySheet.getRow(i).getCell(j).getNumericCellValue();
                        }

                        if (d != null) {
                            temp.add(d.toString());
                        } else if (s != null) {
                            temp.add(s);
                        }
                    }
                }
            } else {
//                temp.add("ошибка обработки ячейки");
//                temp.add("ошибка обработки ячейки");
//                dataList.add(new ExcData(temp.get(0), temp.get(1)));
                continue;
            }
            dataList.add(new ExcData(temp.get(0), temp.get(1)));
        }
        myExcelBook.close();
    }

    public ArrayList<ExcData> findAll() {
        return dataList;
    }

}
