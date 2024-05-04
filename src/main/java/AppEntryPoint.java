import lombok.RequiredArgsConstructor;
import view.MainView;

@RequiredArgsConstructor
public class AppEntryPoint {
    public static void main(String[]args){
        MainView.run();
    }
}
