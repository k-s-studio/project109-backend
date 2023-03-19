package project109.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import project109.backend.entity.Good;
import project109.backend.util.Common;
import project109.backend.util.AttributeCheck;

@Service
public class GoodServiceTest {

    //simulate database
    private List<Good> goods = new ArrayList<Good>();

    //init data
    public GoodServiceTest() {
        goods.add(new Good("whitecat", 300,true));
        goods.add(new Good("blackcat", 400, true));
        goods.add(new Good("nyancat", 77777));
    }

    public List<Good> getList() {
        //call DAO
        List<Good> lst=goods;
        return lst;
    }

    public Good get(String id) throws Exception{ //原本是查不到就回傳NULL
        if (AttributeCheck.stringNotNull(id)) {
            //call DAO
            for (Good g : goods) if( g.getId() == id) return g;
            throw new Exception("id not exist.");
        } throw new Exception("get() with null id.");
    }

    public Good get(int index) throws Exception{ //原本是查不到就回傳NULL
        if (AttributeCheck.indexNotNull(index)) {
            //call DAO
            return goods.get(index);
        } throw new Exception("get() with unprocessable index.");
    }


    public void insert(Good g) throws Exception{
        if(g!=null){
            if(AttributeCheck.stringNotNull(g.getId())) g.setId(Common.CreateRandomId(8));
            //call DAO
            goods.add(g);
        }else throw new Exception("insert() with null object");
    }

    public void insert(List<Good> g_lst) throws Exception {
        if (AttributeCheck.listNotEmpty(g_lst)) {
            //call DAO
            goods.addAll(g_lst);
        }else throw new Exception("insert() with null list");
        return;
    }

    public void update(String id, Good new_g) throws Exception{
        if (new_g != null && AttributeCheck.stringNotNull(id)) {
            new_g.setId(id);
            //call DAO
            for (int i = 0; i < goods.size() ; i++) {
                if( goods.get(i).getId().equals(id)){
                    goods.set(i, new_g);
                }
            }
        }else throw new Exception("update() with null attribute.");
    }

    public void update(Good g) throws Exception{
        if (g != null && AttributeCheck.stringNotNull(g.getId())) {
            //call DAO
            for (int i = 0; i < goods.size() ; i++) {
                if( goods.get(i).getId().equals(g.getId())){
                    goods.set(i, g);
                }
            }
        }else throw new Exception("update() with null attribute.");
    }

    public void delete(String id) throws Exception{
        if (AttributeCheck.stringNotNull(id)) {
            //call DAO
            for (int i = 0; i < goods.size() ; i++) {
                if(goods.get(i).getId().equals(id)){
                    goods.remove(i);
                    return;
                }
            }
            throw new Exception("target not found.");
        }else throw new Exception("delete() with null id.");
    }

    // public void update(String column, String columnValue, String loginId) {
    //     if (attributeCheck.stringsNotNull(column, loginId, columnValue)) {
    //         goodDAO.update(column, columnValue, loginId);
    //     }
    //}
}