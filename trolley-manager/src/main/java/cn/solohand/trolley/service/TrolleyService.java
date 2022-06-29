package cn.solohand.trolley.service;

import cn.solohand.commons.pojo.Trolley;

import java.util.Collection;

public interface TrolleyService {
    Collection<Trolley> findAllTrolleys();
    Trolley findTrolleyById(int id);
    Trolley addTrolley(Trolley trolley);
    Trolley update(int id,Trolley trolley);
    int delete(int id);
}
