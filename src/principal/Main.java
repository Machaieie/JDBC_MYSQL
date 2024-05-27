package principal;

import javax.swing.SwingUtilities;
import views.ProdutoView;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProdutoView().setVisible(true);
            }
        });
    }
}
