import views.PackingView;
import views.UserView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (UserView.userView1()) {
            PackingView.showParking();
        }
    }
}
