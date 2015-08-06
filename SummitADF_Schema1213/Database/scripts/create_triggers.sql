CREATE TRIGGER NEW_ORDER_TRIGGER before
  INSERT ON "S_ORD" FOR EACH row BEGIN IF inserting THEN IF :NEW."ID" IS NULL THEN
  SELECT S_ORD_ID.nextval INTO :NEW."ID" FROM dual;
END IF;
END IF;
END;
/
CREATE TRIGGER NEW_ITEM_TRIGGER before
  INSERT ON "S_ITEM" FOR EACH row BEGIN IF inserting THEN IF :NEW."ITEM_ID" IS NULL THEN
  SELECT S_ITEM_ID.nextval INTO :NEW."ITEM_ID" FROM dual;
END IF;
END IF;
END;
/
CREATE TRIGGER NEW_CUSTOMER_TRIGGER before
  INSERT ON "S_CUSTOMER" FOR EACH row BEGIN IF inserting THEN IF :NEW."ID" IS NULL THEN
  SELECT S_CUSTOMER_ID.nextval INTO :NEW."ID" FROM dual;
END IF;
END IF;
END;
/
create or replace
trigger new_dept_trigger 
before insert on s_dept FOR EACH row BEGIN IF inserting THEN IF :NEW."ID" IS NULL THEN
  SELECT S_DEPT_ID.nextval INTO :NEW."ID" FROM dual;
END IF;
END IF; 
end;
/
create or replace
trigger new_emp_trigger 
before insert on s_emp 
FOR EACH row BEGIN IF inserting THEN IF :NEW."ID" IS NULL THEN
  SELECT S_EMP_ID.nextval INTO :NEW."ID" FROM dual;
END IF;
END IF;
end;
/