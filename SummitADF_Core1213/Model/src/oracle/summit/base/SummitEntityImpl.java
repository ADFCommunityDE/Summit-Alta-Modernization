package oracle.summit.base;

import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;

public class SummitEntityImpl extends EntityImpl {
    public SummitEntityImpl() {
        super();
    }
    
  
    public oracle.jbo.domain.Number nextValSequence(String sequenceName, DBTransaction db) {
        SequenceImpl s = new SequenceImpl(sequenceName, db);
        return s.getSequenceNumber();
    }
}
