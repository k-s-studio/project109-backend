package project109.backend.dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import project109.backend.entity.Good;

@Repository
public interface GoodDAO {
    public List<Good> getAll() throws Exception;
    public Good get(int id) throws Exception;
    public int insert(Good t) throws Exception;
    public int update(Good t) throws Exception;
}
