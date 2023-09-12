package CoreApplication;

import java.net.URL;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

class MyBrowser extends Region {
    HBox toolbar;
    
    WebView webView = new WebView();
    WebEngine webEngine = webView.getEngine();
    
    
    public MyBrowser(){
     
        final URL urlGoogleMaps = getClass().getResource("GoogleMapsV3.html");
        webEngine.load(urlGoogleMaps.toExternalForm());
        webEngine.setJavaScriptEnabled(true);
        getChildren().add(webView);
     
  }
}
