
package mycalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Nizar
 */
public class MyCalculator extends Application {
    
    @Override
    public void start(Stage stage) {
        try
        {
        Parent root = FXMLLoader.load(getClass().getResource("/mycalculator/FX_Calculator.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("fx_calculator.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.titleProperty().set("C a l c u l a t o r    v1.1");
        } catch(Exception e) {
            System.out.print(e.getMessage());
			e.printStackTrace();
		}
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
