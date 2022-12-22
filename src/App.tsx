
import GlobalStyle from "./globalStyles";
import * as C from "./App.styles";

import { Item } from "./types/Item";
import { Category } from "./types/Category";

import { items } from "./data/items";
import { categories } from "./data/categories";
import { useEffect, useState } from "react";
import { filterListByMonth, getCurrentMonth } from "./helpers/dateFilter";
import { TableArea } from "./components/TableArea";
import { InfoArea } from "./components/InfoArea";
import { InputArea } from "./components/InputArea";

export default function App() {
  const [list, setList] = useState(items);
  const [filteredList, setFilteredList] = useState<Item[]>([]);
  const [currentMonth, setCurrentMonth] = useState(getCurrentMonth());
  const [income, setIncome] = useState(0);
  const [expense, setExpense] = useState(0);

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
    let newList = [...list];
    newList.push(item);
    setList(newList);
  }

  const handleDeleteItem = async (deletedItem: Item) => {
    const listWithoutDeletedItem = list.filter(item => {
      return item !== deletedItem;
    });
    
    setList(listWithoutDeletedItem);
  }

  return (
    <>
      <GlobalStyle />

      <C.Container>
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
      </C.Container>
    </>
  );
}
