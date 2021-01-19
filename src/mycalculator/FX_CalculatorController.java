package mycalculator;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Nazar Ahmed Awad
 */
public class FX_CalculatorController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        //Alert alert = new Alert(AlertType.INFORMATION);
        //alert.setTitle("Information Dialog");
        //alert.setHeaderText("Look, an Information Dialog");
        //alert.setContentText(btn.getText());
        //alert.show();
    }
    @FXML
    CheckBox cbPro;
    @FXML
    Button btn;
    @FXML
    Label lblResult;

    boolean flag = true;
    boolean signflag = true;
    String memory = "";

    ArrayList<Object> arr = new ArrayList<>();
    String oldvalue = "";

    //Event of all buttons
    public void btnEvent(ActionEvent evt) {
        btn = (Button) evt.getSource();

        if (!flag) {
            arr.clear();
            lblResult.setText("");
            flag = true;
        }

        if (btn.getText().equals("=")) {
            lblResult.setText(lblResult.getText() + btn.getText());
            flag = false;
            org.reBuild(arr, cbPro.isSelected());
            lblResult.setText(lblResult.getText() + org.result);
        } else if (btn.getText().equals("MR")) {
            lblResult.setText(lblResult.getText() + memory);
            arr.add(memory);
        } else if (btn.getText().equals("C")) {
            arr.clear();
            lblResult.setText("");
        } else if (btn.getText().equals("M+")) {
            memory = String.valueOf(org.result);
        } else if (btn.getText().equals("+/-")) {
            if (!org.checkInput(arr, btn.getText())) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Wronge input");
                alert.setHeaderText("Wronge input");
                alert.setContentText("Please, write a number at the first !!!");
                alert.show();
                return;
            }
            //but sign infront of last number in the array
            if (signflag) { resign(oldvalue); signflag = false;}
            else {
                String v = arr.get(arr.size()-1).toString();
                v = v.substring(1, v.length());
                arr.set(arr.size()-1, v);
                signflag = true;
            }
            lblResult.setText("");
            for (int i = 0; i < arr.size(); i++) {
                if (org.IsDouble(arr.get(i).toString()) || org.IsInteger(arr.get(i).toString())) {
                    if (Double.parseDouble(arr.get(i).toString()) < 0 || Integer.parseInt(arr.get(i).toString()) < 0) {
                        lblResult.setText(lblResult.getText() + "(" + arr.get(i).toString() + ")");
                    } else {
                        lblResult.setText(lblResult.getText() + arr.get(i).toString());
                    }
                } else {
                    lblResult.setText(lblResult.getText() + arr.get(i).toString());
                }
            }
        } else {
            if (!org.checkInput(arr, btn.getText())) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Wronge input");
                alert.setHeaderText("Wronge input");
                alert.setContentText("Please, write a number at the first !!!");
                alert.show();
                return;
            } else {
                lblResult.setText(lblResult.getText() + btn.getText());
                arr.add(btn.getText());
            }
        }
        oldvalue = btn.getText();
    }

    //but sign infront of last number in the array
    public void resign(String oldvalue) {
        String num = "";
        int a = arr.size() - 1;
        if (!org.IsInteger(arr.get(a).toString())) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("+/- button");
            alert.setContentText("Please, write a number at the first and press sign !!!");
            alert.show();
            return;
        }

        while (a >= 0) {
            if (org.IsInteger(arr.get(a).toString()) || arr.get(a).toString().equals(".")) {
                num = arr.get(a).toString() + num;
                arr.remove(a);
                a--;
                if (a == -1) {
                    arr.add(0, "-" + num);
                }
            } else {
                num = "-" + num;
                arr.add(a + 1, num);
                num = "";
                break;
            }
        }
    }

    //Backspace Event
    public void Backspace(ActionEvent event) {
        if (!arr.isEmpty()) {
            arr.remove(arr.size() - 1);
            lblResult.setText(lblResult.getText().substring(0, lblResult.getText().length() - 1));
        }
    }
}
