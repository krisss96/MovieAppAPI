package Controller;

import Controller.Resource.MovieResource;
import Service.MovieService;
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
@RequestMapping("finder/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public List<MovieResource> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/title/{title}")
    public MovieResource findByTitle(@PathVariable String title) {
        return movieService.findByTitle(title);
    }

    @GetMapping("/mood/{mood}")
    public List<MovieResource> findByMood(@PathVariable String mood) {
        return movieService.findByMood(mood);
    }

    @PostMapping("/save")
    public MovieResource saveMovie(@RequestBody MovieResource movieResource) {
        return movieService.save(movieResource);
    }

    @DeleteMapping("/delete")
    public void deleteMovie(@RequestBody MovieResource movieResource) {
        movieService.delete(movieResource);
    }
}
