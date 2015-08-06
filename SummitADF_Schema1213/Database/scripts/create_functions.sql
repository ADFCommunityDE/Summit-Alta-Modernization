CREATE FUNCTION get_product_image 
(product_number IN NUMBER) RETURN VARCHAR2 IS
v_filename VARCHAR2(100);
BEGIN
       SELECT s_image.filename INTO v_filename
       FROM   s_image, s_product
       WHERE  s_image.id = s_product.image_id
              AND
              s_product.id = product_number;
       if v_filename is null then
          v_filename := 'No file.jpg';
       end if;
       RETURN v_filename;
EXCEPTION
       WHEN no_data_found THEN return('No file.jpg');
END;
/
