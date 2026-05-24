package Controller;

import Controller.Resource.MoodResource;
import Service.MoodService;
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
@RequestMapping("finder/api/moods")
@RequiredArgsConstructor
public class MoodController {
	private final MoodService moodService;

	@GetMapping
	public List<MoodResource> findAll() {
		return moodService.findAll();
	}

	@GetMapping("/{id}")
	public MoodResource findById(@PathVariable long id) {
		return moodService.findById(id);
	}

	@PostMapping("/save")
	public MoodResource save(@RequestBody MoodResource moodResource) {
		return moodService.save(moodResource);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody MoodResource moodResource) {
		moodService.delete(moodResource);
	}
}
