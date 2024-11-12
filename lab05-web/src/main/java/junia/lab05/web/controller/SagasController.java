package junia.lab05.web.controller;

import junia.lab05.core.service.SagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sagas")
public class SagasController {

    private final SagaService sagaService;

    @Autowired
    public SagasController(SagaService sagaService) {
        this.sagaService = sagaService;
    }

    @GetMapping("/list")
    public String getListOfSagas(ModelMap modelMap) {
        modelMap.addAttribute("sagas", sagaService.findAllWithPhasesAndMovies());
        return "SagasList";
    }
}
