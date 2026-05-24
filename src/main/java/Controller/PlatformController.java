package Controller;

import Controller.Resource.PlatformResource;
import Service.PlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("finder/api/platforms")
@RequiredArgsConstructor
public class PlatformController {
	private final PlatformService platformService;

	@GetMapping
	public List<PlatformResource> findAll() {
		return platformService.findAll();
	}

	@GetMapping("/{id}")
	public PlatformResource findById(@PathVariable long id) {
		return platformService.findById(id);
	}

	@GetMapping("/movie/{movieId}")
	public PlatformResource findByMovieId(@PathVariable long movieId) {
		return platformService.findByMovieId(movieId);
	}

	@PostMapping("/save")
	public PlatformResource save(@RequestBody PlatformResource platformResource) {
		return platformService.save(platformResource);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody PlatformResource platformResource) {
		platformService.delete(platformResource);
	}
}
