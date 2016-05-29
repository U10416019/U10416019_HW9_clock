//U10416019鄭文琪
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;

public class ClockAnimation extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    ClockPane clock = new ClockPane(); // Create a clock
	
	//create stop and start button to let the time stop or start
	Button stop = new Button("stop");
	Button start = new Button("start");
	start.setPrefSize(120,30);
	stop.setPrefSize(120,30);
	
	//create a HBox to input two button
	HBox hBox1 = new HBox(10);
	hBox1.getChildren().addAll(start, stop);
	
	//create a pane and input the clock and button pane in it
	BorderPane pane = new BorderPane();
	pane.setCenter(clock);
	pane.setBottom(hBox1);
	
	
    // Create a handler for animation
    EventHandler<ActionEvent> eventHandler = e -> {
      clock.setCurrentTime(); // Set a new clock time
    };
    
    
    // Create an animation for a running clock
    Timeline animation = new Timeline(
      new KeyFrame(Duration.millis(1000), eventHandler));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
    
    
    //create the animation of the stop button then stop the time
    stop.setOnAction((ActionEvent e) -> {
    	animation.stop();
	});
    
    //create the animation of the start button then start the time
    start.setOnAction((ActionEvent e) -> {
    	animation.play();
	});
	
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 250, 250);
    primaryStage.setTitle("ClockAnimation"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
