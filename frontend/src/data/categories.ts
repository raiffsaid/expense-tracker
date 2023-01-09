import { Category } from "../types/Category";

export const categories: Category = {
  income: { title: 'Receita', color: 'blue', expense: false },
  expense: { title: 'Despesa', color: 'brown', expense: true },
  investment: { title: 'Investimento', color: 'green', expense: true }, 
};