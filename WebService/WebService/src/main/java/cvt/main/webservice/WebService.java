/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cvt.main.webservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;

/**
 *
 * @author Chau Thinh
 */
public class WebService {

    public static void main(String[] args) {
        spark.Spark.port(4567);
        spark.Spark.get("/demo", (req, res) -> {
            SinhVien sv = new SinhVien("Châu Thịnh", 21);
            ObjectMapper mapper = new ObjectMapper();
            res.status(404);
            res.header("Content-Type", "application/json");
            return mapper.writeValueAsString(sv);
        });
        spark.Spark.get("/get", (req, res) -> {
            SinhVien sv = new SinhVien("Châu Thịnh", 21);
            SinhVien sv2 = new SinhVien("Châu Thịnh", 22);
            ArrayList<SinhVien> arr = new ArrayList<>();
            arr.add(sv);
            arr.add(sv2);
            ObjectMapper mapper = new ObjectMapper();
            res.status(404);
            res.header("Content-Type", "application/json");
            return mapper.writeValueAsString(arr);
        });
    }
}
