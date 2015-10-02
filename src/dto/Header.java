package dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Vilius Kukanauskas
 * Package: dto
 * Date: 30.09.2015
 * Time: 1:42 PM
 */
public class Header {
    private List<String> columns;

    public Header(List<String> columns) {
        this.columns = columns;
    }


    //region getter and setter

    public List<String> getColumns() {
        return columns;
    }


    public void setColumns(List<String> columns) {
        this.columns = columns;
    }
    //endregion getter and setter

}
