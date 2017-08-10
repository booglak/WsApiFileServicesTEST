
import org.hamcrest.core.*;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;

public class FileServicesTest {

    String adminWs = "Basic b3VzeW5pbmFAZ21haWwuY29tOjIyMjIyMg==";
    String admin = "Basic Y2l0eWdhbWV0ZXN0M0BnbWFpbC5jb206MjIyMjIy";
    String host = "http://185.158.153.24:1488";

    int archiveGroupId = 485;
    int certificateId = 21;
    int groupAdminId = 513;
    int groupReportId = 492;
    int regionId = 78819;
    int timetableId = 21;

    @Test
    public void downloadReportCompetences(){
        given().header("Authorization", adminWs).
                when().get(host + "/FileService/Report/Competence/").
                then().statusCode(200).
                body(new StringContains("xlsx"));
    }

    @Test
    public void downloadGroupArchive(){
        given().header("Authorization", adminWs).
                when().get(host + "/FileService/Archive/Group/" + archiveGroupId).
                then().statusCode(200);
    }


    @Test
    public void downloadGroupAdmin(){
        given().header("Authorization", admin).
                when().get(host + "/FileService/Report/GroupAdmin/" + groupAdminId).
                then().statusCode(200);
    }

    @Test
    public void downloadGroupReport(){
        given().header("Authorization", adminWs).
                when().get(host + "/FileService/Report/Group/" + groupReportId).
                then().statusCode(200);
    }

    @Test
    public void downloadOrganizationsReport(){
        given().header("Authorization", adminWs).
                when().get(host + "/FileService/Report/Organization/").
                then().statusCode(200);
    }

    @Test
    public void downloadRegions(){
        given().header("Authorization", adminWs).
                when().get(host + "/FileService/Report/Region/0").
                then().statusCode(200);
    }

    @Test
    public void downloadRegion(){
        given().header("Authorization", adminWs).
                when().get(host + "/FileService/Report/Region/" + regionId).
                then().statusCode(200);
    }

    @Test
    public void downloadTimeTable(){
        given().header("Authorization", admin).
                when().get(host + "/FileService/Timetable/" + timetableId).
                then().statusCode(200);
    }

    @Test
    public void downloadCertificate(){
        given().header("Authorization", admin).
                when().get(host + "/FileService/Certificate/" + certificateId).
                then().statusCode(200);
    }


}
