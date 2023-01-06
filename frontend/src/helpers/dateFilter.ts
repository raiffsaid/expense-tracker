import { Item } from "../types/Item";

export const getCurrentMonth = () => {
  let now = new Date();
  return `${now.getFullYear()}-${now.getMonth()+1}`;
}

export const filterListByMonth = (list: Item[], date: string): Item[] => {
  let newList: Item[] = [];
  let [year, month] = date.split('-');

  for (let i in list) {
    if (
      new Date(list[i].date).getUTCFullYear() === parseInt(year) && 
      (new Date(list[i].date).getUTCMonth() + 1) === parseInt(month)
    ) {
      newList.push(list[i]);
    }
  }
  
  return newList;
}

export const formatDate = (date: string): string => {
  let [year, month, day] = date.split('-');

  return [day, month, year].join('/');
}

export const formatCurrentMonth = (currentMonth: string): string => {
  let [year, month] = currentMonth.split('-');
  let months = ['Janeiro', 
    'Fevereiro', 
    'Março', 
    'Abril', 
    'Maio', 
    'Junho', 
    'Julho', 
    'Agosto', 
    'Setembro', 
    'Outubro', 
    'Novembro', 
  'Dezembro'];

  return `${months[parseInt(month) - 1]} de ${year}`;
}

export const newDateAdjusted = (dateField: string) => {
  let [year, month, day] = dateField.split('-')
  return new Date(parseInt(year), parseInt(month) - 1, parseInt(day))
}