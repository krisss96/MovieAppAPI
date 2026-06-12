package Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Movie {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true)
	private String title;
	private short mins;

	private float rating;

	@ManyToOne
	private Platform platform;

	@ManyToOne
	private Mood mood;

	@ManyToMany
	private List<Feeling> feelings;
	private String quote;
//

	//color pallete
	private String color1;
	private String color2;
	private String color3;
	private String color4;
	private String color5;

	//file paths
	private String heroImage;
	// poster image path
	private String posterPath;
	private String soundtrack;
	private String scene1;
	private String scene2;
	private String scene3;
	private String scene4;
}
