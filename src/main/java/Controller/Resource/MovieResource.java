package Controller.Resource;

import lombok.Data;

import java.util.List;

@Data
public class MovieResource {
	private String title;
	private short mins;
	private float rating;
	private PlatformResource platform;
	private MoodResource mood;
	private List<FeelingResource> feelings;
	private String quote;
	private String color1;
	private String color2;
	private String color3;
	private String color4;
	private String color5;
	private String heroImage;
	// poster image path
	private String posterPath;
	private String soundtrack;
	private String soundtrackName;
	private String scene1;
	private String scene2;
	private String scene3;
	private String scene4;
}
