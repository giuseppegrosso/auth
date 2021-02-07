package it.plansoft.auth.controller.interfaces;/* ggrosso created on 03/02/2021 inside the package - it.plansoft.rubrica.controller */

import it.plansoft.auth.model.IDModel;
import it.plansoft.auth.service.BaseCrudService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * controller di default
 *
 * @param <SERVICE>
 * @param <MODEL>
 * @param <ID>
 */
public abstract class BaseController<SERVICE extends BaseCrudService, MODEL extends IDModel<ID>, ID>
        extends BaseCrudController<SERVICE, MODEL, ID> {
    public BaseController(SERVICE service) {
        super(service);
    }

    protected abstract String getIndexPage();

    @GetMapping("")
    public ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(getIndexPage());
        return modelAndView;
    }
}
