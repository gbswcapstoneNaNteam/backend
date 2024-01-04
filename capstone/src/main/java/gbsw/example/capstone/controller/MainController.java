package gbsw.example.capstone.controller;

import gbsw.example.capstone.domain.Booktext;
import gbsw.example.capstone.domain.Daetree;
import gbsw.example.capstone.repository.DaetreeProjection;
import gbsw.example.capstone.repository.TreeProjection;
import gbsw.example.capstone.service.LottoService;
import gbsw.example.capstone.service.RandomService;
import gbsw.example.capstone.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private final RandomService randomService;
    private final TreeService treeService;

    private final LottoService lottoService;

    @Autowired
    public MainController(RandomService randomService, TreeService treeService, LottoService lottoService) {
        this.randomService = randomService;
        this.treeService = treeService;
        this.lottoService = lottoService;
    }

    @GetMapping("/api/random")
    public List<Booktext> randomText() {
        return randomService.randomText();
    }//난수 바탕 글 구하기

    @GetMapping("/api/tree")
    public List<DaetreeProjection>treeList() {
        return treeService.findAll();
    }//글목록 호출

    @PostMapping("/api/tree/create")
    public String treeCreate(@RequestBody Daetree daetree) {
        return treeService.create(daetree);
    }//글생성
    @PostMapping("/api/tree")
    public List<DaetreeProjection> treeContent(@RequestBody Form form) {
        return treeService.findFull(form.getTitle());
    }//제목검색

    @GetMapping("/api/tree/{code}")
    public List<TreeProjection> treeSang(@PathVariable("code") int code) {
        return treeService.findCode(code);
    }//글 상세정보

    @PostMapping("/api/tree/{code}/delete")
    public String deleteTree(@PathVariable("code") int code,@RequestBody Form form) {
        return treeService.delete(code,form.getName(),form.getPassword());
    }//삭제

    @PostMapping("/api/tree/{code}/update")
    public String updateTree(@PathVariable("code") int code,@RequestBody Form form) {
        return treeService.update(code,form);
    }

    @PostMapping("/api/lotto")
    public List<List<Integer>> lotto(@RequestBody LottoForm form) {
        return lottoService.drawMultipleLottoResults(form.getNum());
    }
}
