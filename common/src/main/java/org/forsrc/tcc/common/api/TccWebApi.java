package org.forsrc.tcc.common.api;

import org.forsrc.tcc.common.exception.TccException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/tcc")
public interface TccWebApi<T, PK> {

    @RequestMapping(value = "/try", method = RequestMethod.POST)
    public ResponseEntity<PK> tccTry(@RequestBody T t) throws TccException;

    @RequestMapping(value = "/confirm/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> confirm(@PathVariable("id") PK id) throws TccException;

    @RequestMapping(value = "/cancel/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> cancel(@PathVariable("id") PK id) throws TccException;
}
