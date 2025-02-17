package com.github.ncttrade.forex.controller;


import com.github.ncttrade.forex.exception.InvalidSymbolException;
import com.github.ncttrade.forex.model.Symbol;
import com.github.ncttrade.forex.service.ForexPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

@RestController
@RequestMapping("api/v1/forex-prices")
@RequiredArgsConstructor
public class LivePriceController {

    private final ForexPriceService forexPriceService;

    @GetMapping("/symbol={symbol}")
    public ResponseEntity<Symbol> livePrice(@PathVariable("symbol") String symbol) throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        return ResponseEntity.ok(forexPriceService.livePrice(symbol));
    }

    @GetMapping("/all")
    public ResponseEntity<Set<Symbol>> livePriceAll() throws URISyntaxException, IOException, InterruptedException, InvalidSymbolException {
        return ResponseEntity.ok(forexPriceService.livePriceAll());
    }
}
