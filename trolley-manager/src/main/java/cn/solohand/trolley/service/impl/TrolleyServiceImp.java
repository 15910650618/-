package cn.solohand.trolley.service.impl;

import cn.solohand.commons.pojo.Trolley;
import cn.solohand.trolley.service.TrolleyService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Hashtable;

@Service
public class TrolleyServiceImp implements TrolleyService {
    private Hashtable<Integer, Trolley> trolleys = new Hashtable<>();
    private int max=0;
    @Override
    public Collection<Trolley> findAllTrolleys() {
        return trolleys.values();
    }

    @Override
    public Trolley findTrolleyById(int id) {
        return trolleys.get(id);
    }

    @Override
    public Trolley addTrolley(Trolley trolley) {
        max++;
        trolley.setId(max);
        trolleys.put(trolley.getId(), trolley);
        return trolley;
    }

    @Override
    public Trolley update(int id, Trolley trolley) {
        trolleys.put(id,trolley);
        return trolley;
    }

    @Override
    public int delete(int id) {
        Trolley trolley = trolleys.remove(id);
        if(trolley!=null){
            return 1;
        }else {
            return 0;
        }
    }
}
