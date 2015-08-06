CREATE 
PACKAGE PRODUCTS_API as 

  procedure insert_product(p_id number,
                           p_name varchar2,
                           p_short_desc varchar2,
                           p_longtext_id number,
                           p_image_id number,
                           p_suggested_whlsl_price number,
                           p_whlsl_units varchar2);
  procedure update_product(p_id number,
                           p_name varchar2,
                           p_short_desc varchar2,
                           p_longtext_id number,
                           p_image_id number,
                           p_suggested_whlsl_price number,
                           p_whlsl_units varchar2);
  procedure delete_product(p_id number);
  procedure lock_product(p_id number,
                           p_name OUT varchar2,
                           p_short_desc OUT varchar2,
                           p_longtext_id OUT number,
                           p_image_id OUT number,
                           p_suggested_whlsl_price OUT number,
                           p_whlsl_units OUT varchar2);
  procedure select_product(p_id number,
                           p_name OUT varchar2,
                           p_short_desc OUT varchar2,
                           p_longtext_id OUT number,
                           p_image_id OUT number,
                           p_suggested_whlsl_price OUT number,
                           p_whlsl_units OUT varchar2);  
end products_api;
/

CREATE 
PACKAGE BODY PRODUCTS_API as

  procedure insert_product(p_id number,
                           p_name varchar2,
                           p_short_desc varchar2,
                           p_longtext_id number,
                           p_image_id number,
                           p_suggested_whlsl_price number,
                           p_whlsl_units varchar2) as
  begin
    INSERT INTO s_product(id,   
                              name,   
                              short_desc,   
                              longtext_id,   
                              image_id,   
                              suggested_whlsl_price,   
                              whlsl_units)
    VALUES(p_id,   
           p_name,   
           p_short_desc,   
           p_longtext_id,   
           p_image_id,   
           p_suggested_whlsl_price,   
           p_whlsl_units);
  end insert_product;

  procedure update_product(p_id number,
                           p_name varchar2,
                           p_short_desc varchar2,
                           p_longtext_id number,
                           p_image_id number,
                           p_suggested_whlsl_price number,
                           p_whlsl_units varchar2) as
  begin
    UPDATE s_product
    SET name = p_name,
      short_desc = p_short_desc,
      longtext_id = p_longtext_id,
      image_id = p_image_id,
      suggested_whlsl_price = p_suggested_whlsl_price,
      whlsl_units = p_whlsl_units
    WHERE id = p_id;
  end update_product;

  procedure delete_product(p_id number) as
  begin
    DELETE FROM s_product
    WHERE id = p_id;
  end;

  procedure lock_product(p_id number,
                           p_name out varchar2,
                           p_short_desc out varchar2,
                           p_longtext_id out number,
                           p_image_id out number,
                           p_suggested_whlsl_price out number,
                           p_whlsl_units out varchar2) as
  begin
    SELECT name,
      short_desc,
      longtext_id,
      image_id,
      suggested_whlsl_price,
      whlsl_units
    INTO p_name,
      p_short_desc,
      p_longtext_id,
      p_image_id,
      p_suggested_whlsl_price,
      p_whlsl_units
    FROM s_product
    WHERE id = p_id FOR UPDATE NOWAIT;
  end lock_product;

  procedure select_product(p_id number,
                           p_name out varchar2,
                           p_short_desc out varchar2,
                           p_longtext_id out number,
                           p_image_id out number,
                           p_suggested_whlsl_price out number,
                           p_whlsl_units out varchar2) as
  begin
    SELECT name,
      short_desc,
      longtext_id,
      image_id,
      suggested_whlsl_price,
      whlsl_units
    INTO p_name,
      p_short_desc,
      p_longtext_id,
      p_image_id,
      p_suggested_whlsl_price,
      p_whlsl_units
    FROM s_product
    WHERE id = p_id;
  end select_product;

end products_api;
/
create or replace package devguidepkg as
  procedure proc_with_no_args;
  procedure proc_with_three_args(n number, d date, v varchar2);
  function  func_with_three_args(n number, d date, v varchar2)
                                 return varchar2;
  procedure proc_with_out_args(n number, d out date, v in out varchar2);
end devguidepkg;

/
create or replace package body devguidepkg as
  procedure proc_with_no_args is
  begin
    null;
  end proc_with_no_args;
  procedure proc_with_three_args(n number,d date, v varchar2) is
  begin
    null;
  end proc_with_three_args;
  function  func_with_three_args(n number,d date, v varchar2)
  return VARCHAR2 is 
  begin
    return to_char(n)||','||to_char(d)||','||v;
  end func_with_three_args;
  procedure proc_with_out_args(n number, d out date, v in out varchar2) is
  begin
    d := sysdate;
    v := '('||v||')';
  end proc_with_out_args;
end devguidepkg;

/