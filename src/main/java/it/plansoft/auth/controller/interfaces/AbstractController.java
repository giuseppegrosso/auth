package it.plansoft.auth.controller.interfaces;/* ggrosso created on 03/02/2021 inside the package - it.plansoft.rubrica.controller */

import it.plansoft.auth.service.interfaces.BaseCrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * controller astratto .
 * @param <SERVICE>
 */
public class AbstractController<SERVICE extends BaseCrudService> {

    protected final static Logger log = LoggerFactory.getLogger(AbstractController.class);

    protected SERVICE service;

}
