import styled from "styled-components";

export const Header = styled.div`
  background-color: darkblue;
  height: 9.375rem;
  text-align: center;

  @media (max-width: 768px) {
      width: 100%;
    }
`;

export const HeaderText = styled.h1`
  margin: 0;
  padding: 0;
  color: #fff;
  padding-top: 1.875rem;
`;

export const Body = styled.div`
  margin: auto;
  max-width: 980px;
  margin-bottom: 50px;

  @media (max-width: 768px) {
    display: flex;
    flex-direction: column;
    margin: 0 14px;
  }
`;