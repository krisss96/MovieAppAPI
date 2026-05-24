package Controller;

import Controller.Resource.FeelingResource;
import Service.FeelingService;
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
@RequestMapping("finder/api/feelings")
@RequiredArgsConstructor
public class FeelingController {
	private final FeelingService feelingService;

	@GetMapping
	public List<FeelingResource> findAll() {
		return feelingService.findAll();
	}

	@GetMapping("/{id}")
	public FeelingResource findById(@PathVariable long id) {
		return feelingService.findById(id);
	}

	@GetMapping("/movie/{movieId}")
	public List<FeelingResource> findFeelingsForMovieByMovieId(@PathVariable long movieId) {
		return feelingService.findFeelingsForMovieByMovieId(movieId);
	}

	@PostMapping("/save")
	public FeelingResource save(@RequestBody FeelingResource feelingResource) {
		return feelingService.save(feelingResource);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody FeelingResource feelingResource) {
		feelingService.delete(feelingResource);
	}
}
