package junia.lab05.web.controller;
import junia.lab05.core.entity.Movie;
import junia.lab05.core.service.MovieService;
import junia.lab05.core.service.PhaseService;

@Controller
@RequestMapping("movies")
public class MoviesController {

    private final MovieService movieService;
    private final PhaseService phaseService;

    @Autowired
    public MoviesController(MovieService movieService, PhaseService phaseService) {
        this.movieService = movieService;
        this.phaseService = phaseService;
    }

    @GetMapping("/add")
    public String addMovieForm(ModelMap model, @RequestParam("phase") long phaseId) {
        model.put("movie", new Movie());
        model.put("phase", phaseService.findById(phaseId));
        return "MovieForm";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute("movie") Movie movie, @RequestParam("phase") long phaseId) {
        movieService.saveMovieInPhase(movie, phaseId);
        return "redirect:../sagas/list";
    }
}
