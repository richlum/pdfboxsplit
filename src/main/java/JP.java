import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.Date;

public class JP {
    public static void main(String[] args){
        User user = new User();
        user.setId(123);
        user.setName("john");
        user.setEmail("xxx");
        user.setDateOfBirth(new Date());

        Jsonb jsonb = JsonbBuilder.create();
        String result = jsonb.toJson(user);
        System.out.println(result);


        Jsonb jsonb1 = JsonbBuilder.create();
        System.out.println(jsonb1.fromJson(result, User.class));

        JsonObject jsonObject = Json.createObjectBuilder()
                .add("name","john")
                .add("job","soft guy")
                .build();
        System.out.println(jsonObject);

    }
}
