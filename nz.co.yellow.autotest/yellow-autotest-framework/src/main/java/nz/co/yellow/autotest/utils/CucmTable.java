package nz.co.yellow.autotest.utils;

import cucumber.api.DataTable;

import java.util.List;
import java.util.Map;

/**
 * Created by weixy on 15/07/14.
 */
public class CucmTable {

    private List<Map<String, String>> data;
    private List<String> columns;

    public CucmTable(DataTable dataTable) {
        data = dataTable.asMaps();
        columns = dataTable.topCells();
    }

    public Map<String, String> getRowMap(int rowIndex) {
        return data.get(rowIndex -1);
    }

    public String getCell(String column, int rowIndex) {
        Map<String, String> rowMap = this.getRowMap(rowIndex);
        return rowMap.get(column);
    }

}
