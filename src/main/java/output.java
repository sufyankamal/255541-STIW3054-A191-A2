
import org.json.JSONException;
import org.json.JSONObject;



public class output  {
    JSONObject[] x;

    output(JSONObject[] x) {
        this.x = x;
    }

    public void output() throws JSONException {
        System.out.println("|   No  |    Login ID   |    No of repositories    |   No of follower   |    ID    | ");

        for (int i = 0; i < x.length; i++) {

            System.out.printf("| %-5s |  %12s  |  %-20s  |  %-16s  |   %-5s  |\n", i + 1, x[i].getString("login"), x[i].getInt("public_repos"), x[i].getInt("followers"), x[i].getInt("id"), x[i].getInt("following"));

        }


    }


}
