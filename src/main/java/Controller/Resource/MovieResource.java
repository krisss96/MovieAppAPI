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
	private short color1;
	private short color2;
	private short color3;
	private short color4;
	private short color5;
	private String heroImage;
	// poster image path
	private String posterPath;
	private String soundtrack;
	private String scene1;
	private String scene2;
	private String scene3;
	private String scene4;
}
