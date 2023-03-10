import { ArrowLeft, ArrowRight } from "phosphor-react";
import { formatCurrentMonth } from "../../helpers/dateFilter";
import { ResumeItem } from "../ResumeItem";
import * as C from "./styles";

type Props = {
  currentMonth: string;
  onMonthChange: (newMonth: string) => void;
  income: number;
  expense: number;
}

export function InfoArea({ currentMonth, onMonthChange, income, expense }: Props) {
  const handlePreviousMonth = () => {
    let [year, month] = currentMonth.split('-');
    let currentDate = new Date(parseInt(year), parseInt(month) - 1, 1);
    currentDate.setMonth(currentDate.getMonth() - 1);
    onMonthChange(`${currentDate.getFullYear()}-${currentDate.getMonth() + 1}`);
  }

  const handleNextMonth = () => {
    let [year, month] = currentMonth.split('-');
    let currentDate = new Date(parseInt(year), parseInt(month) - 1, 1);
    currentDate.setMonth(currentDate.getMonth() + 1);
    onMonthChange(`${currentDate.getFullYear()}-${currentDate.getMonth() + 1}`);
  }

  return (
    <C.Container>
      <C.MonthArea>
        <C.MonthArrow onClick={handlePreviousMonth}>
          <ArrowLeft size={32} />
        </C.MonthArrow>
        <C.MonthTitle>{formatCurrentMonth(currentMonth)}</C.MonthTitle>
        <C.MonthArrow onClick={handleNextMonth}>
          <ArrowRight size={32} />
        </C.MonthArrow>
      </C.MonthArea>

      <C.ResumeArea>
        <ResumeItem title="Receitas" value={income} />
        <ResumeItem title="Despesas" value={expense} />
        <ResumeItem 
          title="Balanço" 
          value={income - expense} 
          color={(income - expense) < 0 ? 'red' : 'green'}
        />
      </C.ResumeArea>
    </C.Container>
  );
}