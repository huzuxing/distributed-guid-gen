import com.id.generate.factory.GuidGenServiceFactory;
import com.id.generate.service.GuidGenService;

/**
 * Created by huzuxing on 2018/9/20.
 */
public class GuidGenTest {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                GuidGenService guidGenService = GuidGenServiceFactory.idService();
                long id = 0;
                try {
                    id = guidGenService.genGuid();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(id + " " + guidGenService.expGuid(id));
            }).start();
        }
    }
}
