package com.example.clase4multiplestablas.repository;

import com.example.clase4multiplestablas.dto.EmpleadosRegionDto;
import com.example.clase4multiplestablas.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(nativeQuery = true, value = "select r.regionDescription as regiondescription, count(e.employeeid) as cantidadempleados\n" +
            "FROM region r\n" +
            "         inner join territories t on (r.regionid = t.regionid)\n" +
            "         inner join employeeterritories et on (t.territoryid = et.territoryid)\n" +
            "         inner join employees e on (e.employeeid = et.employeeid)\n" +
            "group by r.regionid")
    public List<EmpleadosRegionDto> listaEmpleadosPorRegion();

}
