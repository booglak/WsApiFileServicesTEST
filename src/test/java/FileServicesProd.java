import org.hamcrest.core.*;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;

public class FileServicesProd {

    String admin = "Basic emxhdGFib2dvbWF6QHlhbmRleC5ydTpKeVJ5OW5Q";
    String adminWs = "Basic Ym9vZ2xha0BnbWFpbC5jb206MjIyMjIy";
    String host = "https://worldskillsacademy.ru:8080";

    int archiveGroupId = 485;
    int certificateId = 204;
    int groupAdminId = 511;
    int groupReportId = 491;
    int regionId = 78819;
    int timetableId = 122;

    @Test
    public void downloadReportCompetences(){
        given().header("Authorization", adminWs).
                when().get(host + "/FileService/Report/Competence/").
                then().statusCode(200).
                body(new StringContains("xlsx")).
                body(new StringContains("Компетенции"));
    }

    @Test
    public void downloadGroupArchive(){
        given().header("Authorization", adminWs).
                when().get(host + "/FileService/Archive/Group/" + archiveGroupId).
                then().statusCode(200).
                body(new StringContains("ValueResponseOfstring"));
    }

    @Test
    public void downloadCertificate(){
        given().header("Authorization", admin).
                when().get(host + "/FileService/Certificate/" + certificateId).
                then().statusCode(200).
                body(new StringContains("ValueResponseOfstring"));
    }

    @Test
    public void downloadGroupAdmin(){
        given().header("Authorization", admin).
                when().get(host + "/FileService/Report/GroupAdmin/" + groupAdminId).
                then().statusCode(200).
                body(new StringContains("ValueResponseOfstring"));
    }

    @Test
    public void downloadGroupReport(){
        given().header("Authorization", adminWs).
                when().get(host + "/FileService/Report/Group/" + groupReportId).
                then().statusCode(200).
                body(new StringContains("xlsx")).
                body(new StringContains("Группа"));
    }

    @Test
    public void downloadOrganizationsReport(){
        given().header("Authorization", adminWs).
                when().get(host + "/FileService/Report/Organization/").
                then().statusCode(200).
                body(new StringContains("xlsx")).
                body(new StringContains("Организации"));
    }

    @Test
    public void downloadRegions(){
        given().header("Authorization", adminWs).
                when().get(host + "/FileService/Report/Region/0").
                then().statusCode(200).
                body(new StringContains("xlsx")).
                body(new StringContains("Регион"));
    }

    @Test
    public void downloadRegion(){
        given().header("Authorization", adminWs).
                when().get(host + "/FileService/Report/Region/" + regionId).
                then().statusCode(200).
                body(new StringContains("xlsx")).
                body(new StringContains("Регион"));
    }

    @Test
    public void downloadTimeTable(){
        given().header("Authorization", admin).
                when().get(host + "/FileService/Timetable/" + timetableId).
                then().statusCode(200).
                body(new StringContains("ValueResponseOfstring"));
    }



}
