import styled from "styled-components";

export const TableLine = styled.tr`
  &:nth-child(even) {
    background-color: #9ecbf2;
  }
`;

export const TableColumn = styled.td`
  padding: 10px 15px;
`;

export const Category = styled.div<{ color: string }>`
  display: inline-block;
  padding: 5px 10px;
  border-radius: 5px;
  color: #fff;
  background-color: ${props => props.color};
`;

export const Value = styled.div<{ color: string }>`
  color: ${props => props.color};
`;

export const Button = styled.button`
  background: transparent;
  border: 0;
  cursor: pointer;
  line-height: 0; 
  border-radius: 2px;

  &:hover {
      color: red;
  }
`;