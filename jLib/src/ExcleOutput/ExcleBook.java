package ExcleOutput;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcleBook {
    /**
     * 针对Book类进行导出的操作
     * @param list
     */

    private String path="D:/book.xls";
    public void excleOut(List<Book> list) {
        WritableWorkbook book = null;
        try {
            // 创建一个excle对象
            book = Workbook.createWorkbook(new File(path));
            // 通过excle对象创建一个选项卡对象
            WritableSheet sheet = book.createSheet("sheet1", 0);
            // 创建一个单元格对象 列 行 值
            // Label label = new Label(0, 2, "test");
            for (int i = 0; i < list.size(); i++) {
                Book book2 = list.get(i);
                Label label1 = new Label(0, i, String.valueOf(book2.getId()));
                Label label2 = new Label(1, i, book2.getName());
                Label label3 = new Label(2, i, book2.getAuthor());

                // 将创建好的单元格对象放入选项卡中
                sheet.addCell(label1);
                sheet.addCell(label2);
                sheet.addCell(label3);
            }
            // 写入目标路径
            book.write();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                book.close();
            } catch (WriteException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * 针对Book类进行导入的操作
     * @return
     */
    public List<Book> excleIn() {
        List<Book> list = new ArrayList<>();
        Workbook workbook = null;
        try {
            // 获取Ecle对象
            workbook = Workbook.getWorkbook(new File(path));
            // 获取选项卡对象 第0个选项卡
            Sheet sheet = workbook.getSheet(0);
            // 循环选项卡中的值
            for (int i = 0; i < sheet.getRows(); i++) {
                Book book = new Book();
                // 获取单元格对象
                Cell cell0 = sheet.getCell(0, i);
                // 取得单元格的值,并设置到对象中
                book.setId(Integer.valueOf(cell0.getContents()));
                // 获取单元格对象，然后取得单元格的值,并设置到对象中
                book.setName(sheet.getCell(1, i).getContents());
                book.setAuthor(sheet.getCell(2, i).getContents());
                list.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workbook.close();
        }
        return list;
    }

    public static void main(String[] args) {
        ExcleBook book = new ExcleBook();
        List<Book> list = new ArrayList<>();
        Book book2 = new Book();
        book2.setId(1);
        book2.setName("啊啊啊");
        book2.setAuthor("啊啊啊");
        Book book3 = new Book();
        book3.setId(2);
        book3.setName("哦哦哦");
        book3.setAuthor("哦哦哦");
        list.add(book2);
        list.add(book3);
        book.excleOut(list);
        List<Book> books = book.excleIn();
        for (Book bo : books) {
            System.out.println(bo.getId() + " " + bo.getName() + " " + bo.getAuthor());
        }
    }
}

