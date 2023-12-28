package api.endpoints;

public class Routes {

	public static String baseURL =	"https://petstore.swagger.io/v2";
	
	public static String createUser_Post_Url = baseURL+"/user";
	public static String getUserDetails_Get_Url = baseURL+"/user/{userName}";
	public static String updateUserDetatils_Put_Url = baseURL+"/user/{userName}";
	public static String deleteUser_Delete_Url = baseURL+"/user/{userName}";
	
}
