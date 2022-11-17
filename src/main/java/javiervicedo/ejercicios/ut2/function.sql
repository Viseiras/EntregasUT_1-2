CREATE OR REPLACE FUNCTION public.cuentaDiscos()
    RETURNS int
    LANGUAGE plpgsql
AS $$
declare
    cont integer;
BEGIN
    select count(*) into cont from Discos;
    return cont;
END;
$$;