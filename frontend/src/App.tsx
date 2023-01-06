
import GlobalStyle from "./globalStyles";
import * as C from "./App.styles";

import { Item } from "./types/Item";

import { categories } from "./data/categories";
import axios from 'axios';
import { useEffect, useState } from "react";
import { filterListByMonth, getCurrentMonth } from "./helpers/dateFilter";
import { TableArea } from "./components/TableArea";
import { InfoArea } from "./components/InfoArea";
import { InputArea } from "./components/InputArea";

export default function App() {
  const [list, setList] = useState<Item[]>([]);
  const [filteredList, setFilteredList] = useState<Item[]>([]);
  const [currentMonth, setCurrentMonth] = useState(getCurrentMonth());
  const [income, setIncome] = useState(0);
  const [expense, setExpense] = useState(0);

  useEffect(() => {
    axios.get(`${import.meta.env.VITE_BACKEND_URL}/users/63b72b3f93a76f001c0fbfc8/items`).then((response) => {
      setList(response.data);
    })
  }, [currentMonth]);

  useEffect(() => {
      setFilteredList(filterListByMonth(list, currentMonth));
  }, [list, currentMonth]);

  useEffect(() => {
    let incomeCount = 0;
    let expenseCount = 0;

    for(let i in filteredList) {
      (categories[filteredList[i].category].expense) ? 
        expenseCount += filteredList[i].value : 
        incomeCount += filteredList[i].value;
    }

    setIncome(incomeCount);
    setExpense(expenseCount);
  }, [filteredList])

  const handleMonthChange = (newMonth: string) => {
    setCurrentMonth(newMonth);
  }
 
  const handleAddItem = async (item: Item) => {
    await axios.post(`${import.meta.env.VITE_BACKEND_URL}/users/63b72b3f93a76f001c0fbfc8/items`, item);
    await axios.get(`${import.meta.env.VITE_BACKEND_URL}/users/63b72b3f93a76f001c0fbfc8/items`).then((response) => {
      setList(response.data);
    });
  }

  const handleDeleteItem = async (itemId: string) => {
    await axios.delete(`${import.meta.env.VITE_BACKEND_URL}/users/63b72b3f93a76f001c0fbfc8/items/${itemId}`);
    await axios.get(`${import.meta.env.VITE_BACKEND_URL}/users/63b72b3f93a76f001c0fbfc8/items`).then((response) => {
      setList(response.data);
    });
  }

  return (
    <>
      <GlobalStyle />
      
      <C.Header>
        <C.HeaderText>Sistema Financeiro</C.HeaderText>
      </C.Header>

      <C.Body>
        <InfoArea 
          currentMonth={currentMonth} 
          onMonthChange={handleMonthChange} 
          income={income}
          expense={expense}
        />

        <InputArea onAdd={handleAddItem} />

        <TableArea list={filteredList} onDeleteItem={handleDeleteItem} />
      </C.Body>
    </>
  );
}
