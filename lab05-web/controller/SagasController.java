package junia.lab05.web.controller;

import junia.lab05.core.service.SagaService;

@Controller
@RequestMapping("sagas")
public class SagasController {

    private final SagaService sagaService;

    @Autowired
    public SagasController(SagaService sagaService) {
        this.sagaService = sagaService;
    }

}
